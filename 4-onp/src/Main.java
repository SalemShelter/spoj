import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int expressoes = sc.nextInt();
		sc.nextLine();
		for(int i = 1; i<=expressoes; i++) {
			String expressao = sc.nextLine();
			String[] tokens = expressao.split("");
			String saida = "";
			Stack pilha = new Stack();
			int ite = 0;
			for(String token : tokens) {
				if("()".contains(token)) {
					if(token.equals("(")) pilha.push(token);
					else {
						String t = (String) pilha.pop();
						while(!t.equals("(")) {
							saida+=t;
							t = (String) pilha.pop();
						}						
					}
				} else if("+-*/^".contains(token)) {
					if("+-".contains(token)) {
						if("*/^".contains((String)pilha.peek()))
							saida += (String) pilha.pop();
					} else if("*/".contains(token)) {
						if("^".contains((String)pilha.peek()))
							saida += (String) pilha.pop();
					}
					pilha.push(token);
				} else {
					saida += token;
				}
				if(ite++ == tokens.length - 1) {
					while(!pilha.isEmpty()) {
						saida += pilha.pop();
					}
				}
			}
			System.out.println(saida);
		}

	}

}
