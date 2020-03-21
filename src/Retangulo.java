/**
 *
 * @author caroline rosa
 */
import java.util.Scanner;

public final class Retangulo
{
    private double base;
    
    private double altura;
    
    public Retangulo()
    {
        setBase();
        setAltura();
        area();
        perimetro();
        pitagoras();
    }
    
    public void setBase()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o tamanho da base: ");
        this.base = in.nextDouble();
    }
    
    public void setAltura()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o tamanho da altura: ");
        this.altura = in.nextDouble();
    }
    
    public void area()
    {
        double area = this.base * this.altura;
        System.out.println("Area: " + area);
    }
    
    public void perimetro()
    {
        double perimetro = this.base + this.altura;
        System.out.println("Perimetro: " + perimetro);
    }
    
    public void pitagoras()
    {
        double diag = Math.sqrt((base*base) + (altura*altura));
        System.out.println("Diagonal: " + diag);
    }
}
