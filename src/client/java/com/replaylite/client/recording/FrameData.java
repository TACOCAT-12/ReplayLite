package com.replaylite.client.recording;

public class FrameData {

    public final double x;
    public final double y;
    public final double z;

    public final float yaw;
    public final float pitch;

    public final long time;

    public FrameData(
            double x,
            double y,
            double z,
            float yaw,
            float pitch,
            long time
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.time = time;
    }
}