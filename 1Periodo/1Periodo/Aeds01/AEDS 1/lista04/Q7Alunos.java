package lista4;
import java.util.Scanner;

/**
 *
 * @author Wisney Tadeu de Almeida Assis dos Santos
 */
public class Q7Alunos {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = 0;
        int f = 0;
        int idade = 0;
        int maiorIdade = 0;
        int somaIdade = 0;
        char op;
        boolean erro;
        
        System.out.println("Esse programa calcula :" +
                    "-Percentual de homens e de mulheres.\n" +
                    "- Percentual de alunos maiores em idade.\n" +
                    "- Idade média da turma");
        System.out.print("Digite o número de alunos da turma: ");
        int n = s.nextInt();
        
        do {
            System.out.print("m - Masculino\n" +
            "f - feminino\n?  ");
            op = s.next().charAt(0);
            switch(op){
                case 'm':
                    m++;
                    do {
                        System.out.print("Digite a idade do aluno: ");
                        idade = s.nextInt();
                        if (idade<0 || 100<idade) {
                            erro = true;
                            System.out.println("Idade inválida! Digite uma idade de 0 - 100");
                        }else{
                            erro = false;
                        }
                        
                    } while (erro);
                    
                    somaIdade += idade;
                    if(idade > 17){
                        maiorIdade++;
                    }
                    
                    break;
                case 'f':
                    f++;
                    do {
                        System.out.print("Digite a idade do aluno: ");
                        idade = s.nextInt();
                        if (idade<0 || 100<idade) {
                            erro = true;
                            System.out.println("Idade inválida! Digite uma idade de 0 - 100");
                        }else{
                            erro = false;
                        }
                        
                    } while (erro);
                    somaIdade += idade;
                    if(idade > 17){
                        maiorIdade++;
                    }
                    
                    break;
                default:
                    System.out.println("Opição inválida!");
                    break;
            }
            n--;
        } while (n!=0);
        
        System.out.println("M: " + (m*100.0/(m+f)) + "%");
        System.out.println("F: " + (f*100.0/(m+f)) + "%");
        System.out.println("Maiores de idade: " + (maiorIdade*100.0/(m+f)) + "%");
        System.out.println("Idade média: " + (somaIdade/(m+f)));
        
                
    }
}
