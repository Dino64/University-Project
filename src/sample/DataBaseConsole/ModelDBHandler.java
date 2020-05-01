package src.sample.DataBaseConsole;

import src.sample.Model.Model;

import java.sql.Connection;

public abstract class ModelDBHandler<T extends Model> implements Database  {

    protected Connection connection;


}
