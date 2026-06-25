#include <stdio.h>
#include <stdlib.h>

int main(){
    printf("Hello World!\n");
    printf("o numero %d e inteiro, enquanto o %f e float\n",2, 2.5);
    printf("o numero %d e inteiro, enquanto o %1.2f e float\n",2, 2.5);    // o 1.2 quer dizer que: 1 casa inteira e 2 casas decimais
    printf("a soma de %d e %d e igual a: %d \n", 2, 3, 2 + 3);
    //system("pause");

    // declaraçãode variáveis

    int x;
    float cons;
    double doub;
    char c;
    x = 5;
    cons = 5.2;
    doub = 5.21312312323;
    c = 'a';

    printf("%d e %1.1f e %f, %c \n", x, cons, doub, c);

    // criar várias variaveis - int n1, n2, n3

    // char por ter + de 1 caracter
    char nome[40] = "Gustavo Albanett";    // cria um char com 40 espaços
    

    //scanner
    printf("Qual seu nome?");
    scanf("%s", &nome);    // esse & comercial serve para ser possível printar essa variável e mais alguma outra no mesmo print
    printf("Qual sua idade?");
    scanf("%i", &x);
    if(x <= 17){
        printf("Prazer %s, voce tem %i anos de idade, sendo menor de idade", nome, x);
    }
    else if(x >= 68){
        printf("Tu e idoso");
    }
    else{
        printf("Ih mane, tu e de maior");
    }

}
/* 
    fica tudo comentario

*/

// comentario único