# PROJETO FINAL DA DISCIPLINA DE SISTEMAS OPERACIONAIS

Este repositório contém os arquivos correspondentes ao projeto final da disciplina Sistemas Operacionais, ofertada para o Bacheralado em Tecnlogia de Informação(BTI) na Universidade Federal do Rio Grande do Norte(UFRN).

## Descrição

Faça um programa que calcule a quantidade de cilindros percorridos considerando 4
algoritmos de escalonamento de discos recebendo informações na forma de um arquivo de
configuração: 1) A posição inicial do cabeçote de leitura e 2) a fila de espera contendo o número
dos cilindros a serem lidos.

Os quatro algoritmos são os seguintes:

1) FCFS

2) SSTF

3) SCAN considerando o bit de sentido como SOBE (indo do menor para o maior cilindro)

4) SCAN considerando o bit de sentido como DESCE (indo do maior para o menor cilindro)

O programa deve receber como parâmetro (utilizando argc argv, por exemplo) o nome de um
arquivo de configuração. Este arquivo contém as seguintes informações:

• Um inteiro com a posição inicial do cabeçote

• Um inteiro n que determina o tamanho da fila de espera

• n inteiros que são a fila de espera

O programa deve ler o arquivo de configuração e, para cada algoritmo de escalonamento, imprimir
na tela:

1) A ordem da fila de espera acessada

2) O total de cilindros percorridos

## Como executar
O arquivo entrada.txt contem as configurações iniciais, para quaisquer alterações, modifique-o.

Dentro da pasta src, digite no terminal:

```bash
javac Main.java
```
Logo após, digite:

```bash
java Main
```
##### ATENCAO!:

é importante que o arquivo entrada.txt esteja na mesma pasta do src.

Exemplo de arquivo de configuração:
```bash
53
8
98 183 37 122 14 124 65 67
```
Exemplo de saida:
```bash
FCFS
    Ordem: 53, 98, 183, 37, 122, 14, 124, 65, 67
    Cilindros: 640
SSTF
    Ordem: 53, 65, 67, 37, 14, 98, 122, 124, 183
    Cilindros: 236
SCAN SOBE
    Ordem: 53, 37, 14, 65, 67, 98, 122, 124, 183
    Cilindros: 208
SCAN DESCE
    Ordem: 53, 65, 67, 98, 122, 124, 183, 37, 14
    Cilindros: 299
```
## Autor
 
- [_Victor Hugo_](https://github.com/victorhugofr).
