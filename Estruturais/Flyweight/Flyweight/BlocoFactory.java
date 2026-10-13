package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class BlocoFactory {

    private static Map<String, TipoBloco> blocos = new HashMap<>();

    public static TipoBloco getBloco(String nome, String textura, boolean solido){
        String chave = nome + "-" + textura+ "-" + solido;

        if (!blocos.containsKey(chave)){
            blocos.put(chave, new TipoBloco(nome, textura, solido));
        }
        return blocos.get(chave);
    }
}
