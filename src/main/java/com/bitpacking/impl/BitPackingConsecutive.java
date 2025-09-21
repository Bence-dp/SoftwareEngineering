package com.bitpacking.impl;

import com.bitpacking.api.BitPacking;
import com.bitpacking.model.CompressedData;
import com.bitpacking.model.Data;

public class BitPackingConsecutive extends AbstractBitPacking {


    @Override
    public CompressedData compress(Data data) {
        int[] array = data.getArray();
        int size = array.length;
        int bitsPerValue = getRequiredBits(array);

        // nombre de valeurs qui tiennent dans 32 bits
        int valuesPerInt = 32 / bitsPerValue;

        // taille du tableau compressé
        int compressedSize = getCompressedSize(size, bitsPerValue, false);
        int[] compressed = new int[compressedSize];

        int index = 0;
        int pos = 0;     // position

        for (int value : array) {
            compressed[index] = writeBits(compressed[index], value, pos, bitsPerValue);
            pos += bitsPerValue;
            
            if (pos >= 32) {
                index++;
                pos = 0;
            }
        }

        return new CompressedData(compressed, size, bitsPerValue, false);
    }


    @Override
    public Data decompress(CompressedData compressedData) {

        return new Data();
    }

    @Override
    public int get(int i) {
        return 0;
    }
}
