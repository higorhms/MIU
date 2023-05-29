    class AulaInverter {

        public static void main(String args[]) {
            int numeroParaInverter = 123;
            int numeroInvertido = 0;


            if(numeroParaInverter > 0){
                while(numeroParaInverter > 0){
                    numeroInvertido = numeroInvertido * 10;
                    numeroInvertido = numeroInvertido + (numeroParaInverter % 10);
                    numeroParaInverter = numeroParaInverter / 10;
                }
            }else{
               while(numeroParaInverter < 0){
                   numeroInvertido = numeroInvertido * 10;
                   numeroInvertido = numeroInvertido + (numeroParaInverter%10);
                   numeroParaInverter = numeroParaInverter / 10;
               }
            }

            System.out.println(numeroInvertido);
        }
    }