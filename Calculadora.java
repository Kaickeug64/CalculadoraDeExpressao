public class Calculadora {
    float reultdado;
    char operacao[] = new char[100];
    int status;
    /**
     0 = resolvida
     1 = resolvendo operação comum
     2 = resolvendo chaves
     3 = resolvendo colchetes
     4 = resolvendo parentesess
     */
    void setStatus(int n){
        this.status = n;
    }
    int getStatus(){
        return this.status;
    }
    void setOperacao(String ope){
        this.operacao = ope.toCharArray();
    }
    char[] getOperacao(){
        return this.operacao;
    }

    boolean verificar4(char ope[]){
        for (int i : ope){
            if (ope[i] == '(')
                return true;
        }
        return false;
    }

    void resolver4(char ope[]) {
        for (int i = 0; i < ope.length; i++) {
            if (ope[i] == '(' && ope[i + 1] != '-') {
                //recebendo o primeiro número
                boolean test = true;
                int cont = 0;
                int nums[] = new int[10];
                int n1 = 0;
                int posicao = i + 1;
                //coletando o primero número
                do {
                    if (ope[posicao] >= '0' && ope[posicao] <= '9') {
                        nums[cont] = Character.getNumericValue(ope[posicao]);
                        ope[posicao] = ' ';
                        cont++;
                        posicao++;
                        test = true;
                    }
                    else if (ope[posicao] == ' '){
                        posicao++;
                        test = true;
                    }
                    else {
                        test = false;
                    }
                } while (test);

                for (int j = 0; j < cont; j++) {
                    n1 += nums[j] * Math.pow(10, cont - j - 1);
                }
                System.out.print(n1+" ");


                char operador = descobrirOperador(ope,posicao,nums,cont,test);
                System.out.print(operador);

                int contn1 = cont;
                int n2 = 0;

                //coletando o segundo número
                do {
                    if (ope[posicao] >= '0' && ope[posicao] <= '9') {
                        nums[cont] = Character.getNumericValue(ope[posicao]);
                        ope[posicao] = ' ';
                        cont++;
                        posicao++;
                        test = true;
                    }
                    else if (ope[posicao] == ' '){
                        posicao++;
                        test = true;
                    }
                    else {
                        test = false;
                    }
                } while (test);

                for (int j = 0; j < cont-contn1; j++) {
                    n2 += nums[cont-j-1] * Math.pow(10,j);
                }
                System.out.print(" "+n2);

                if (ope[posicao] != ')'){
                    do {
                        if (ope[posicao] == ' ')
                            posicao++;
                        else if (ope[posicao] == '+' || ope[posicao] == '-' || ope[posicao] == '/' || ope[posicao] == '*'){

                        }
                    }while(ope[posicao] != ')');
                }
            }
        }
    }
    private char descobrirOperador(char ope[], int posicao, int nums[] , int cont ,boolean test){
        do {
            if (ope[posicao ] != ' ') {
                if (ope[posicao] == '+' || ope[posicao] == '-' || ope[posicao] == '/' || ope[posicao] == '*') {
                    char temp = ope[posicao];
                    ope[posicao] = ' ';
                    test = false;
                    return temp;
                }
                posicao++;
            }
        }while (test);
        return 0;
    }
}

