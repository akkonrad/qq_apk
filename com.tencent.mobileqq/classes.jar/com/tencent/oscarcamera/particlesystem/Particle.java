package com.tencent.oscarcamera.particlesystem;

public class Particle
{
  public double[] a = new double[10];
  public double birth;
  public int currFrame;
  public int frameCount;
  public boolean musicPlayed = false;
  public Particle next = null;
  int param_offset;
  public String tex;
  public int total = 0;
  public double[] touchedPosition = new double[3];
  
  void copy(Particle paramParticle)
  {
    if (paramParticle == null) {
      return;
    }
    this.tex = paramParticle.tex;
    this.frameCount = paramParticle.frameCount;
    this.currFrame = paramParticle.currFrame;
    int i = 0;
    int j = this.a.length;
    while (i < j)
    {
      this.a[i] = paramParticle.a[i];
      i += 1;
    }
    this.touchedPosition[0] = paramParticle.touchedPosition[0];
    this.touchedPosition[1] = paramParticle.touchedPosition[1];
    this.touchedPosition[2] = paramParticle.touchedPosition[2];
  }
  
  public String toString()
  {
    return String.format("(%f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %d, %d)", new Object[] { Double.valueOf(this.a[2]), Double.valueOf(this.a[0]), Double.valueOf(this.a[1]), Double.valueOf(this.a[7]), Double.valueOf(this.a[8]), Double.valueOf(this.a[9]), Double.valueOf(this.a[3]), Double.valueOf(this.a[4]), Double.valueOf(this.a[5]), Double.valueOf(this.a[6]), Integer.valueOf(this.frameCount), Integer.valueOf(this.currFrame) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.Particle
 * JD-Core Version:    0.7.0.1
 */