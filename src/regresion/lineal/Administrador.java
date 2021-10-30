/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regresion.lineal;

import static java.lang.Math.sqrt;
import java.util.Vector;

public class Administrador {
    private  Vector valoresX;
    private  Vector valoresY;
    private float covarianza;
    private float desvX;
    private float desvY;
    private float error;
    private float coefRegresion;
    private float A;
    private float mediaX;
    private float mediaY;
    private String formulaCadena;
    
    public Administrador(Vector X, Vector Y){
        float cov2;
        valoresX = X;
        valoresY = Y;
        sacarCovarianzaYDesviaciones();
        cov2 = covarianza/(desvX*desvY);
        error = cov2*cov2;
        sacarEcuaciones();
    }
    
    public float dameCovarianza() {
        return covarianza;
    }

    public float dameDesvX() {
        return desvX;
    }

    public float dameDesvY() {
        return desvY;
    }

    public float dameError() {
        return error;
    }

    public float dameCoefRegresion() {
        return coefRegresion;
    }

    public float dameA() {
        return A;
    }
    public String dameformula(){
        return formulaCadena;
    }
    
    private void sacarCovarianzaYDesviaciones(){
        float sumaX=0, sumaY=0;
        float promedioX, promedioY;
        float auxX, auxY;
        float sumaX2=0, sumaY2=0, sumaCuadrados=0;
        Vector xCuadrada = new Vector();
        Vector yCuadrada = new Vector();
        Vector valoresJuntos = new Vector();
        
        for(int i = 0; i < valoresX.size(); i++){
            sumaX+= (float) valoresX.get(i);
            sumaY+= (float) valoresY.get(i);
        }
        
        mediaX = sumaX/valoresX.size();
        mediaY = sumaY/valoresY.size();
        
        for(int i = 0; i<valoresX.size(); i++){
            auxX = (float) valoresX.get(i) - mediaX;
            auxY = (float) valoresY.get(i) - mediaY;
            xCuadrada.add(auxX*auxX);
            yCuadrada.add(auxY*auxY);
            valoresJuntos.add(auxX*auxY);
            sumaX2 += auxX*auxX;
            sumaY2 += auxY*auxY;
            sumaCuadrados += auxX*auxY;
        }
        covarianza = sumaCuadrados/valoresX.size();
        desvX = (float) sqrt(sumaX2/valoresX.size());
        desvY = (float) sqrt(sumaY2/valoresY.size());
    }
    private void sacarEcuaciones(){
        float b, a;
        coefRegresion = covarianza/(desvY*desvY);
        A = mediaX - (coefRegresion*mediaY);
        formulaCadena = "X = "+A+" + "+coefRegresion+"Y";
    }
    public float predecir(float Y){
        float X;
        X = A + coefRegresion*Y;
        return X;
    }
    
}

