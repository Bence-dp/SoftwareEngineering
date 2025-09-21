package com.bitpacking.impl;

import com.bitpacking.api.BitPacking;

public abstract class AbstractBitPacking implements BitPacking {

    protected int getRequiredBits(int[] array) {
        int max = 0;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }

        if (max == 0) {
            return 1; // au moins 1 bit si tout est nul
        } else {
            // 32 - nombre de zéros à gauche du binaire de nb max
            return 32 - Integer.numberOfLeadingZeros(max);
        }
    }

    protected int mask(int n) {
        return (1 << n) - 1;
    }

    protected int writeBits(int target, int value, int position, int bits) {
        // masque qui recouvre la zone à écrire
        int mask = ((1 << bits) - 1) << position;

        // efface la zone et  place la valeur
        int cleared = target & ~mask;
        int shifted = (value << position) & mask;

        return cleared | shifted;
    }

    protected int readBits(int source, int position, int bits) {
        int shifted = source >>> position;   // décale à droite
        int masked = shifted & ((1 << bits) - 1); // applique mask
        return masked;
    }

    protected int getCompressedSize(int n, int bitsPerValue, boolean allowCross) {
        if (allowCross) {
            // total de bits nécessaires
            long totalBits = (long) n * bitsPerValue;

            // division par 32 arrondi
            return (int) ((totalBits + 31) >>> 5);
        } else {
            // nb de valeurs qui tiennent dans 32 bits
            int valuesPerInt = 32 / bitsPerValue;

            // division avec arrondi
            return (n + valuesPerInt - 1) / valuesPerInt;
        }
    }

}
