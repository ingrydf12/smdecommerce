/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Ingryd Duarte
 */
public final class Config {
    private static final Properties props = carregarProps();

    public static final String BD_DRIVER  = getEnvKey("BD_DRIVER");
    public static final String BD_URL     = getEnvKey("BD_URL");
    public static final String BD_USUARIO = getEnvKey("BD_USUARIO");
    public static final String BD_SENHA   = getEnvKey("BD_SENHA");

    /* Construtor privado para instanciação */
    private Config() {}

    /* Pra não precisar passar os valores sensíveis diretamente no config, foi criado essas duas funções aqui pra:
    * 1: Carregar as propriedades (env)
    * 2: Puxar o valor de cada chave a partir das propriedades
    * A forma de conectar ainda segue a mesma ideia, mas também modular com o ModuloConexao.java
    */
    private static Properties carregarProps() {
        Properties p = new Properties();
        try (InputStream is = Config.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is == null) throw new IllegalStateException("config.properties não encontrado");
            p.load(is);
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao carregar config.properties", e);
        }
        return p;
    }

    private static String getEnvKey(String key) {
        String valor = props.getProperty(key);
        if (valor == null || valor.isBlank())
            throw new IllegalStateException("Propriedade obrigatória ausente: " + key);
        return valor;
    }
}