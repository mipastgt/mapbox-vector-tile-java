package com.wdtinc.mapbox_vector_tile.encoding;

import com.wdtinc.mapbox_vector_tile.Command;

public final class GeomCmd {

    private static int CLOSE_PATH_HDR = cmdHdr(Command.ClosePath, 1);

    /**
     * <p>Encodes a 'command header' with the first 3 LSB as the command id, the remaining bits
     * as the command length. See the vector-tile-spec for details.</p>
     *
     * @param cmd command to execute
     * @param length how many times the command is repeated
     * @return encoded 'command header' integer
     */
    public static int cmdHdr(Command cmd, int length) {
        return (cmd.getCmdId() & 0x7) | (length << 3);
    }

    /**
     * @return encoded 'command header' integer for {@link Command#ClosePath}.
     */
    public static int closePathCmdHdr() {
        return CLOSE_PATH_HDR;
    }

    /**
     * Maximum allowed 'command header' length value.
     */
    public static final int CMD_HDR_LEN_MAX = (int) (Math.pow(2, 29) - 1);
}
