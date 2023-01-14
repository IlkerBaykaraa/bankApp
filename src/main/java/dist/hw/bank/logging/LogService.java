package dist.hw.bank.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService{
    @Autowired
    private ILogRepository logRepository;

    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }

    @Override
    public List<Log> getAllLogsById(long id) {
        return logRepository.findAllByUserId(id);
    }


}
