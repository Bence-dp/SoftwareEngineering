package com.bitpacking.model;

public class CompressedData {
    private final int[] compressed;
    private final int size;
    private final int bitsPerValue;
    private final boolean allowCross;

    public CompressedData(int[] compressed, int size, int bitsPerValue, boolean allowCross) {
        this.compressed = compressed;
        this.size = size;
        this.bitsPerValue = bitsPerValue;
        this.allowCross = allowCross;
    }
    public int[] getCompressed() {
        return compressed;
    }
    public int getSize() {
        return size;
    }
    public int getBitsPerValue() {
        return bitsPerValue;
    }
    public boolean isAllowCross() {
        return allowCross;
    }

}
