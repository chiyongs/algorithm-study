package leetcode.recommendlist;

public class ConvertTheTemperature2469 {
    public double[] convertTemperature(double celsius) {
        double res[]=new double[2];
        res[1]=(((double)9/5)*celsius)+32;
        res[0]=273.15+celsius;
        return res;
    }
}
