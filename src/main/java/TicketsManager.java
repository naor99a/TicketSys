import java.util.*;

public class TicketsManager implements ITicketManager{

    private int lastTicketId = 0;
    private HashMap<Integer, ITicket> tickets = new HashMap<>();

    private TicketStatisticsManager statMgr = new TicketStatisticsManager();


    @Override
    public void addTicket(ITicket ticket) {
        lastTicketId++;
        ticket.setId(lastTicketId);
        tickets.put(lastTicketId, ticket);
        if (ticket instanceof ITicketSeverity)
        {
            statMgr.addTicketForAnalyzing((ITicketSeverity)ticket);
        }
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


    private ITicket getRandomTicket() {
        Random rand = new Random();

        TicketBase.TicketType[] ticketTypeValues = TicketBase.TicketType.values();
        TicketBase.TicketType type = ticketTypeValues[rand.nextInt(ticketTypeValues.length)];

        ITicketSeverity.Severity[] severityValues = ITicketSeverity.Severity.values();
        ITicketSeverity.Severity severity = severityValues[rand.nextInt(severityValues.length)];

        TicketBase newTicket;

        switch (type) {
            case SECURITY:
                newTicket = new TicketTypeSecurity("Bla bla bla 0", severity, "CVE-2019-1214");
                break;
            case CONFIGURATION:
                newTicket = new TicketTypeConfiguration("Bla bla bla 1", severity);
                break;
            case BEST_PRACTICE:
            default:
                newTicket = new TicketTypeBestPractice("Bla bla bla 2", severity, "CVE-2019-1215");
        }

        if (rand.nextInt(2) == 1) {
            newTicket.setResolutionAndClose("Resolved.");
        }

        return newTicket;
    }
    public void generateMultipleRandomTickets(int num) {
        for (int i = 0; i < num; i++) {
            ITicket newTicket = getRandomTicket();
            this.addTicket(newTicket);
        }
    }

    public void printAllTickets() {
        for (ITicket ticket : this.tickets.values()) {
            System.out.println(ticket);
        }

        System.out.println("Stats:\n" + statMgr.calcStatistics());
    }

    public static void main(String[] args) {
        TicketsManager mgr = new TicketsManager();
        mgr.generateMultipleRandomTickets(1000);
        mgr.printAllTickets();
    }
}
