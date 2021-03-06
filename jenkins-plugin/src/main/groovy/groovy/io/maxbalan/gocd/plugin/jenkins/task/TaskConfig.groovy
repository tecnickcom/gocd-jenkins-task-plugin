package groovy.io.maxbalan.gocd.plugin.jenkins.task

import org.junit.platform.commons.util.StringUtils

import com.google.common.base.MoreObjects


/**
 * Created on: 05/02/2020
 *
 * @author Maxim Balan
 * */
class TaskConfig {
    private final String url
    private final String jobName
    private final String jobToken
    private final String username
    private final String password
    private final boolean printLog
    private final Map<String, String> params

    public TaskConfig(String url,
                      String jobName,
                      String jobToken,
                      String username,
                      String password,
                      boolean printLog,
                      Map<String, String> params) {
        this.url = url
        this.jobName = jobName
        this.jobToken = jobToken
        this.username = username
        this.password = password
        this.printLog = printLog
        this.params = params
    }

    public String getUrl() {
        return url
    }

    public String getJobName() {
        return jobName
    }

    public String getUsername() {
        return username
    }

    public String getPassword() {
        return password
    }

    public boolean isPrintLog() {
        return printLog
    }

    public String getJobToken() {
        return this.jobToken
    }

    public boolean isTokenAuthentication() {
        return StringUtils.isNotBlank(this.jobToken)
    }

    public Map<String, String> getParams() {
        final HashMap<String, String> map = new HashMap<>(this.params)
        if (this.isTokenAuthentication()) {
            map.put("token", this.jobToken)
        }

        return map
    }

    @Override
    String toString() {
        return MoreObjects.toStringHelper(this)
                .add("url", url)
                .add("jobName", jobName)
                .add("jobToken", jobToken)
                .add("username", username)
                .add("password", password)
                .add("printLog", printLog)
                .add("params", params)
                .toString()
    }
}
