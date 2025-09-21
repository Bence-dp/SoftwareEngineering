package com.bitpacking.api;

import com.bitpacking.model.CompressedData;
import com.bitpacking.model.Data;

public interface BitPacking {
    public CompressedData compress(Data data);
    public Data decompress(CompressedData compressedData);
    public int get(int i);
}
