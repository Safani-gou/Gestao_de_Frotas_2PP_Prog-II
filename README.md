# GESTAO DE FROTAS (Sistema de Gestao de Veiculos em Java)

	Disciplina:				Programacao II
	Repositorio GitHub:		https://github.com/Safani-gou/Gestao_de_Frotas_2PP_Prog-II.git
	Linguagem:				Java
	Ano:					2025

* MEMBROS DO GRUPO:

		- Estefani Famorosa 	Nº 20240217
		- Jorje Veloso          Nº 20241500
		- Josemar Chipandeca    Nº 20242447

# Descrição do Projecto: 

O presente projecto consiste no desenvolvimento de um sistema de Gestao de Frotas em linguagem Java. O sistema permite gerir uma frota de veiculos, incluindo o cadastro, consulta, aluguer, devolucao e remocao de carros, bem como o registo historico de todos os alugueres realizados.

# Objectivo:

O objectivo principal e consolidar os conhecimentos de programacao orientada a objectos em Java, aplicando os seguintes conceitos obrigatorios:

	•  Estruturas de seleccao (if/else, switch)
	•  Estruturas de repeticao (for, do/while)
	•  ArrayList para gestao de coleccoes de objectos
	•  Registos (classes com atributos e metodos)
	•  Manipulacao de Strings
	•  Funcoes/metodos organizados por responsabilidade
	•  Ficheiros para persistencia de dados (leitura e escrita em .txt)

# Modo de Funcionamento:

O sistema é excutado em terminal (linha de comandos) e apresenta um menu interactivo ao utilizador. Ao iniciar, o programa carrega automaticamente os dados guardados em ficheiros. Ao encerrar, todos os dados sao guardados. O utilizador navega pelo menu introduzindo o numero da opcao desejada.

# Menu Principal:

						MENU
		________________________________________________________
		
		1. Cadastrar novo carro (matricula, marca, modelo, ano)
		2. Listar todos os carros da frota
		3. Listar apenas os carros disponiveis para aluguer
		4. Procurar um carro pela matricula
		5. Alugar um carro a um cliente (regista data)
		6. Devolver um carro (regista data de devolucao)
		7. Consultar historico completo de alugueres
		8. Remover um carro da frota
		0. Encerrar o sistema
		________________________________________________________
* Novas Funcionalidades:

	- Gestão de Cliente:

			Registar Cliente
			Consultar Cliente
  			Renover Cliente
    - Gestão de Aluguer:

			Registar Aluguer
  			Registar Devolução
			Consultar Historico de Alluguer
    - Gestão de Manutenção: 

			Enviar Veiculo Para Manutenção
  			Concluir Manuteção
  			Consultar Fila da Manutenção
    - Relatórios:
  
			Total de Veiculo
			Veículo Desponíveis
  			Veículos Alugados
  			Veículo em Manuntenção
  			Clientes com Mair número de Alugueres

# Classes Principais:

* Classe Carro: 

Representa um veiculo da frota. Contem os dados do carro e o estado de disponibilidade.

	Atributo:			Tipo:		Descrição:
	matricula			String		Identificador unico do veiculo
	marca				String		Marca do veiculo (ex: Toyota)
	modelo				String		Modelo do veiculo (ex: Corolla)
	ano					int			Ano de fabricacao
	disponivel			boolean		Indica se o carro esta disponivel para aluguer
	clienteAtual		String		Nome do cliente que tem o carro alugado

* Metodos:

  		getMatricula(), onivel(), setDisponivel(), setClienteAtual(), toFileString(), fromFileString(), toString()

* Classe Aluguer:
 
Regista cada operacao de aluguer realizada no sistema, com o cliente e as datas.

	Atributo:			Tipo:		Descrição:
	matricula			String		Matricula do carro alugado
	cliente				String		Nome do cliente
	dataAluguer			String		Data de inicio do aluguer
	dataDevolucao		String		Data de devolucao (vazia se ainda alugado)

* Metodos:

		getMatricula(), getCliente(), getDataDevolucao(), setDataDevolucao(), toFileString(), fromFileString(), toString()

* Classe FrotaService:
 
Contem toda a logica de negocio do sistema. Gere as listas de carros e alugueres e trata da persistencia em ficheiros.

	•  adicionarCarro() — valida matricula duplicada e adiciona o carro
	•  listarCarros() — lista todos os carros da frota
	•  listarCarrosDisponiveis() — filtra apenas carros disponiveis
	•  procurarCarro() — pesquisa por matricula
	•  alugarCarro() — regista aluguer e marca carro como indisponivel
	•  devolverCarro() — regista devolucao e liberta o carro
	•  removerCarro() — remove carro (impede remocao se estiver alugado)
	•  listarHistoricoAlugueres() — mostra todos os alugueres registados
	•  guardarCarros() / carregarCarros() — persistencia em carros.txt
	•  guardarAlugueres() / carregarAlugueres() — persistencia em alugueres.txt

* Classe Main:
 
Ponto de entrada do programa. Implementa o menu interactivo em terminal usando Scanner e um ciclo do/while. Instancia o FrotaService e chama os seus metodos conforme a opcao escolhida pelo utilizador.

* Integracao de Ficheiros:
 
O sistema utiliza dois ficheiros de texto para garantir que os dados nao se perdem ao encerrar o programa:

	Ficheiro		Conteudo					Formato de cada linha
	carros.txt		Todos os carros cadastrados	matricula;marca;modelo;ano;disponivel;cliente
	alugueres.txt	Historico de alugueres		matricula;cliente;dataAluguer;dataDevolucao

Os ficheiros são carregados automaticamente ao iniciar (FileReader + BufferedReader) e guardados apos cada operacao que altere os dados (FileWriter + PrintWriter).

* Estrutura do Projecto: 

		* Gestao_de_Frotas_2PP_ProgamacaoII/
   		 * src/ 
				Carro.java
  				Aluguer.java
				rotaService.java
				Main.java
  					carros.tx (gerado automaticamente)
  					alugueres.txt (gerado automaticamente)



