package by.IvanHWtms.Service;

import by.IvanHWtms.DAO.InMemorySessionDAO;
import by.IvanHWtms.Entity.Session;


import java.util.List;

public class SessionService {

    InMemorySessionDAO sessionDAO = new InMemorySessionDAO();

    public void addSessionInfo(Session session) {
        sessionDAO.saveSession(session);
    }

    public List<Session> getSessionInfo() {
        return sessionDAO.getSessions();
    }

}
