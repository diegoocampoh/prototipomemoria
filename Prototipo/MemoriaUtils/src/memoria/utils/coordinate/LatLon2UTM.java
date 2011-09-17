 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.utils.coordinate;

/**
 *
 * @author diego
 */
public class LatLon2UTM {
    public static String convertLatLonToUTM(double latitude, double longitude)
    {
      CoordinateConversion.validate(latitude, longitude);
      String UTM = "";

      setVariables(latitude, longitude);

      String longZone = getLongZone(longitude);
      LatZones latZones = new LatZones();
      String latZone = latZones.getLatZone(latitude);

      double _easting = getEasting();
      double _northing = getNorthing(latitude);

      UTM = longZone + " " + latZone + " " + ((int) _easting) + " "
          + ((int) _northing);
      // UTM = longZone + " " + latZone + " " + decimalFormat.format(_easting) +
      // " "+ decimalFormat.format(_northing);

      return UTM;

    }

    protected static void setVariables(double latitude, double longitude)
    {
      latitude = CoordinateConversion.degreeToRadian(latitude);
      rho = equatorialRadius * (1 - e * e)
          / CoordinateConversion.POW(1 - CoordinateConversion.POW(e * CoordinateConversion.SIN(latitude), 2), 3 / 2.0);

      nu = equatorialRadius / CoordinateConversion.POW(1 - CoordinateConversion.POW(e * CoordinateConversion.SIN(latitude), 2), (1 / 2.0));

      double var1;
      if (longitude < 0.0)
      {
        var1 = ((int) ((180 + longitude) / 6.0)) + 1;
      }
      else
      {
        var1 = ((int) (longitude / 6)) + 31;
      }
      double var2 = (6 * var1) - 183;
      double var3 = longitude - var2;
      p = var3 * 3600 / 10000;

      S = A0 * latitude - B0 * CoordinateConversion.SIN(2 * latitude) + C0 * CoordinateConversion.SIN(4 * latitude) - D0
          * CoordinateConversion.SIN(6 * latitude) + E0 * CoordinateConversion.SIN(8 * latitude);

      K1 = S * k0;
      K2 = nu * CoordinateConversion.SIN(latitude) *CoordinateConversion.COS(latitude) * CoordinateConversion.POW(sin1, 2) * k0 * (100000000)
          / 2;
      K3 = ((CoordinateConversion.POW(sin1, 4) * nu * CoordinateConversion.SIN(latitude) * Math.pow(CoordinateConversion.COS(latitude), 3)) / 24)
          * (5 - CoordinateConversion.POW(CoordinateConversion.TAN(latitude), 2) + 9 * e1sq * CoordinateConversion.POW(CoordinateConversion.COS(latitude), 2) + 4
              * CoordinateConversion.POW(e1sq, 2) * CoordinateConversion.POW(CoordinateConversion.COS(latitude), 4))
          * k0
          * (10000000000000000L);

      K4 = nu * CoordinateConversion.COS(latitude) * sin1 * k0 * 10000;

      K5 = CoordinateConversion.POW(sin1 * CoordinateConversion.COS(latitude), 3) * (nu / 6)
          * (1 - CoordinateConversion.POW(CoordinateConversion.TAN(latitude), 2) + e1sq * CoordinateConversion.POW(CoordinateConversion.COS(latitude), 2)) * k0
          * 1000000000000L;

      A6 = (CoordinateConversion.POW(p * sin1, 6) * nu * CoordinateConversion.SIN(latitude) * CoordinateConversion.POW(CoordinateConversion.COS(latitude), 5) / 720)
          * (61 - 58 * CoordinateConversion.POW(CoordinateConversion.TAN(latitude), 2) + CoordinateConversion.POW(CoordinateConversion.TAN(latitude), 4) + 270
              * e1sq * CoordinateConversion.POW(CoordinateConversion.COS(latitude), 2) - 330 * e1sq
              * CoordinateConversion.POW(CoordinateConversion.SIN(latitude), 2)) * k0 * (1E+24);

    }

    protected static String getLongZone(double longitude)
    {
      double longZone = 0;
      if (longitude < 0.0)
      {
        longZone = ((180.0 + longitude) / 6) + 1;
      }
      else
      {
        longZone = (longitude / 6) + 31;
      }
      String val = String.valueOf((int) longZone);
      if (val.length() == 1)
      {
        val = "0" + val;
      }
      return val;
    }

    protected static double getNorthing(double latitude)
    {
      double northing = K1 + K2 * p * p + K3 * CoordinateConversion.POW(p, 4);
      if (latitude < 0.0)
      {
        northing = 10000000 + northing;
      }
      return northing;
    }

    protected static double getEasting()
    {
      return 500000 + (K4 * p + K5 * CoordinateConversion.POW(p, 3));
    }

    // Lat Lon to UTM variables

    // equatorial radius
    static double equatorialRadius = 6378137;

    // polar radius
    static double polarRadius = 6356752.314;

    // flattening
    static double flattening = 0.00335281066474748;// (equatorialRadius-polarRadius)/equatorialRadius;

    // inverse flattening 1/flattening
    static double inverseFlattening = 298.257223563;// 1/flattening;

    // Mean radius
    static double rm = CoordinateConversion.POW(equatorialRadius * polarRadius, 1 / 2.0);

    // scale factor
    static double k0 = 0.9996;

    // eccentricity
    static double e = Math.sqrt(1 - CoordinateConversion.POW(polarRadius / equatorialRadius, 2));

    static double e1sq = e * e / (1 - e * e);

    static double n = (equatorialRadius - polarRadius)
        / (equatorialRadius + polarRadius);

    // r curv 1
    static double rho = 6368573.744;

    // r curv 2
    static double nu = 6389236.914;

    // Calculate Meridional Arc Length
    // Meridional Arc
    static double S = 5103266.421;

    static double A0 = 6367449.146;

    static double B0 = 16038.42955;

    static double C0 = 16.83261333;

    static double D0 = 0.021984404;

    static double E0 = 0.000312705;

    // Calculation Constants
    // Delta Long
    static double p = -0.483084;

    static double sin1 = 4.84814E-06;

    // Coefficients for UTM Coordinates
    static double K1 = 5101225.115;

    static double K2 = 3750.291596;

    static double K3 = 1.397608151;

    static double K4 = 214839.3105;

    static double K5 = -2.995382942;

    static double A6 = -1.00541E-07;


}
