package dist.hw.bank.logging;

import java.util.List;

public interface ILogService {

    List<Log> getAllLogs();
    void saveLog(Log log);

    List<Log> getAllLogsById(long id);
}
