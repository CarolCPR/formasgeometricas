/**
 *
 * @author caroline rosa
 * 
 * 
 * 2.      Defina a classe Triângulo, sabendo que todos os triângulos possuem 3 lados. 
 *         Defina os atributos da sua classe e os métodos de instância básicos. 
 *         Implemente também métodos para:
 * a)      Verificar e retornar o tipo do triângulo (escaleno, equilátero ou isósceles).
 * b)      Calcular e retornar a área do triângulo.
 * c)      Calcular e retornar o perímetro do triângulo.
 * Implemente uma classe Principal, contendo um método main,  e instancie nela 2 objetos da classe Triângulo.
 * Mostre os resultados dos métodos a, b, e c para cada Triângulo.
 * 
 */
import java.util.Scanner;

public final class Triangulo
{
    private double lado1;
    private double lado2;
    private double lado3;
    private int tipo;

    public Triangulo()
    {
        setLado1();
        setLado2();
        setLado3();
        tipoTriangulo();
        areaTriangulo();
    }
    
    public void setLado1()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe um lado do triangulo: ");
        lado1 = in.nextDouble();
    }
    
    public void setLado2()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o outro lado do triangulo: ");
        lado2 = in.nextDouble();
    }
    
    public void setLado3()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o último lado do triangulo: ");
        lado3 = in.nextDouble();
    }
    
    public void tipoTriangulo()
    {
        if(lado1 ==  lado2 && lado2 == lado3)
        {
            System.out.print("É um triangulo equilatero!");
            this.tipo = 1;
        }
        
        else if(lado1 == lado2 || lado2 == lado3 || lado1 == lado3)
        {
            System.out.print("É um triangulo isóceles!");
            this.tipo = 2;
        }
        
        else
        {
            System.out.print("É um triangulo escaleno!");
            this.tipo = 3;
        }
    }  
 //b)      Calcular e retornar a área do triângulo.  
    public void areaTriangulo()
    {
	double altura;
        double area;

        switch (tipo) {
        //equilatero
            case 1:
                altura = Math.sqrt(Math.pow(lado3,2) - Math.pow(lado1/2,2));
                area = (lado1 * altura) / 2;
                break;
        //isóceles
            case 2:
                if(lado1 == lado2)
                {
                    altura = Math.sqrt(Math.pow(lado1,2) - Math.pow(lado3/2,2));
                    area = (lado3 * altura) / 2;
                }
                else if(lado1 == lado3)
                {
                    altura = Math.sqrt(Math.pow(lado1,2) - Math.pow(lado2/2,2));
                    area = (lado2 * altura) / 2;
                }
                else //lado2 == lado3
                {
                    altura = Math.sqrt(Math.pow(lado2,2) - Math.pow(lado1/2,2));
                    area = (lado1 * altura) / 2;
                }   break;
        //escalenos
            default:
                double angulo; //lei dos cossenos a² = b² + c² - 2bc. cosα //considero que a base sempre será o lado maior para calcular a altura
                if(lado1 < lado2 && lado1 < lado3)
                { 
                    angulo = Math.acos((Math.pow(lado2,2) + Math.pow(lado3,2) - Math.pow(lado1,2)) / (2*lado2*lado3));
                    angulo = 180 / 3.1415 * angulo;
                    //sim, eu preciso do angulo para saber a área
                    //altura h = c . sen(A) sendo A o angulo de frente do menor lado
                    if(lado2 > lado3)
                    {
                        altura = lado3 * Math.sin(angulo);
                        // A = (b * h) / 2
                        area = (lado2 * altura) / 2;
                    }
                    else //quer dizer que o lado3 é maior
                    {
                        altura = lado2 * Math.sin(angulo);
                        area = (lado3 * altura) / 2;
                    }
                }else if(lado2 < lado3 && lado2 < lado1)
                {
                    angulo = Math.cos((Math.pow(lado1,2) + Math.pow(lado3,2) - Math.pow(lado2,2)) / (2*lado1*lado3));
                    if(lado1 > lado3)
                    {
                        altura = lado3 * Math.sin(angulo);
                        area = (lado1 * altura) / 2;
                    }
                    else //quer dizer que o lado3 é maior
                    {
                        altura = lado1 * Math.sin(angulo);
                        area = (lado3 * altura) / 2;
                    }
                }else //lado3 menor
                {
                    angulo = Math.cos((Math.pow(lado2,2) + Math.pow(lado1,2) - Math.pow(lado3,2)) / (2*lado2*lado1));
                    if(lado2 > lado1)
                    {
                        altura = lado1 * Math.sin(angulo);
                        area = (lado2 * altura) / 2;
                    }
                    else //quer dizer que o lado1 é maior
                    {
                        altura = lado2 * Math.sin(angulo);
                        area = (lado1 * altura) / 2;
                    }
                }   break;
        }
        System.out.print("A área do triângulo é de: " + area);
    }
}

