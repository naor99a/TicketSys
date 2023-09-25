import java.util.*;

public class TicketsManager implements ITicketManager{

    private int lastId = 1;

    private Hashtable<Integer, ITicket> tickets;

    public TicketsManager() {
        List list = new ArrayList<ITicket>();
    }

    @Override
    public void addTicket(ITicket ticket) {
        lastId++;
        ticket.setId(lastId);
        tickets.put(lastId, ticket);
    }

    @Override
    public void removeTicket(ITicket ticket) {
        tickets.remove(ticket.getId());
    }

    @Override
    public ITicket getTicket(int id) {
        return tickets.get(id);
    }

    @Override
    public Collection<ITicket> getTickets() {
        return tickets.values();
    }
}
