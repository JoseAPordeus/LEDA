package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo
		// também será modificado.
		Vetor<Aluno> vetor = new Vetor<Aluno>(20);

		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);

		Aluno a1 = new Aluno("Pedro", 5);
		Aluno a2 = new Aluno("Maria", 7);
		Aluno a3 = new Aluno("Joao", 9);
		Aluno a4 = new Aluno("Patricia", 8);
		vetor.inserir(a1);
		vetor.inserir(a2);
		vetor.inserir(a3);
		vetor.inserir(a4);
		
		vetor.procurar(a3);

		vetor.remover(a3);

		vetor.procurar(a3);

		vetor.isCheio();
		vetor.isVazio();

		vetor.maximo();
		vetor.minimo();
	}
}
