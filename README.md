# StormtechSortBook

#Requisitos para Aplica��o:
###Para apenas execu��o:
-� recomendado possuir a m�quina virtual do Java no m�nimo vers�o 1.8, disponivel em: https://www.java.com/pt_BR/download/manual.jsp
###Para desenvolver:
-Necess�ria maquina virtual do Java  para desenvolvedores, o JDK:
http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html
-Recomenda-se o uso de uma IDE, sugiro o Eclipse
https://eclipse.org/home/index.php


#Funcionalidades
-H� a op��o de carregador dados de um objeto serializado chamado livros.bin, nele contem uma lista de objetos com os seguintes valores:
	Title: Java How to Program | Author: Deitel & Deitel | Edition: 2007
	Title: Patterns of Enterprise Application Architecture | Author: Martin Fower | Edition: 2002
	Title: Head First Design Patterns | Author: Elisabeth Freeman | Edition: 2004
	Title: Internet & World Wide Web: How to Program | Author: Deitel & Deitel | Edition: 2007
	
-Se optar pelo carregamento desses dados serializados, voc� poder� adicionar novos valores apartir do menu de cadastro, h� a op��o de limpar dados da tabela e carregar novamente os dados serializados

-Organiza��o de valores funciona de seguinte forma:
	*Organizar por Titulo: Ordem crescente de valores
	*Organizar por Autor: Ordem crescente de valores, em caso de valores iguais, � ordenado por ordem 	decrescente de titulo
	*Organizar por Edi��o: Ordem decrescente de valores, em caso de valores iguais, � ordenado por 	ordem decrescente de autores, que por sua vez, se possuir valores iguais, o crit�rio de 	diferencia��o � por ordem crescente de t�tulo
	
-H� uma condi��o que n�o permite o cadastro de valores vazios na tabela, al�m disso, h� uma exce��o que trata do problema.

	