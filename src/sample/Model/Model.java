package sample.Model;

import java.io.Serializable;

public interface Model extends Serializable {
    boolean matches(String key);
}
