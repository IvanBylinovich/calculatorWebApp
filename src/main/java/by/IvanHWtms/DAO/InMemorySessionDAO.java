package by.IvanHWtms.DAO;

import by.IvanHWtms.Entity.Session;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data

public class InMemorySessionDAO {

    private static List<Session> sessions = new ArrayList();

    public void saveSession(Session session){
        sessions.add(session);
    }

    public List getSessions(){
        return sessions;
    }
}
