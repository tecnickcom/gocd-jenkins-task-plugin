package groovy.io.maxbalan.gocd.plugin.jenkins.helpers


/**
 * Created on: 05/02/2020
 *
 * @author Maxim Balan
 * */
trait GsonHelper {

    public static <T> T fromGson(String json, Class<T> classOfT) {
        GsonSingleton.gson().fromJson(json, classOfT)
    }

    public static  <T> String toGson(T obj) {
        GsonSingleton.gson().toJson(obj)
    }

}
