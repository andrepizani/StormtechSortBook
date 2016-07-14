# StormtechSortBook

#Requisitos para Aplicação:
###Para apenas execução:
-É recomendado possuir a máquina virtual do Java no mínimo versão 1.8, disponivel em: https://www.java.com/pt_BR/download/manual.jsp
###Para desenvolver:
-Necessária maquina virtual do Java  para desenvolvedores, o JDK:
http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html
-Recomenda-se o uso de uma IDE, sugiro o Eclipse
https://eclipse.org/home/index.php


#Funcionalidades
-Há a opção de carregador dados de um objeto serializado chamado livros.bin, nele contem uma lista de objetos com os seguintes valores:
	Title: Java How to Program | Author: Deitel & Deitel | Edition: 2007
	Title: Patterns of Enterprise Application Architecture | Author: Martin Fower | Edition: 2002
	Title: Head First Design Patterns | Author: Elisabeth Freeman | Edition: 2004
	Title: Internet & World Wide Web: How to Program | Author: Deitel & Deitel | Edition: 2007
	
-Se optar pelo carregamento desses dados serializados, você poderá adicionar novos valores apartir do menu de cadastro, há a opção de limpar dados da tabela e carregar novamente os dados serializados

-Organização de valores funciona de seguinte forma:
	*Organizar por Titulo: Ordem crescente de valores
	*Organizar por Autor: Ordem crescente de valores, em caso de valores iguais, é ordenado por ordem 	decrescente de titulo
	*Organizar por Edição: Ordem decrescente de valores, em caso de valores iguais, é ordenado por 	ordem decrescente de autores, que por sua vez, se possuir valores iguais, o critério de 	diferenciação é por ordem crescente de título
	
-Há uma condição que não permite o cadastro de valores vazios na tabela, além disso, há uma exceção que trata do problema.

	