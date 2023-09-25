import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketsProgram {
    static final int TICKETS_NUM = 1000;

    public static void main(String[] args) {
        TicketsManager ticketsMgr = new TicketsManager();

        // create 1000 random tickets
        for (int index = 0; index < TICKETS_NUM; index++) {
            ticketsMgr.addTicket(generateRandomTicket());
        }

        // print statistics (Tasks 1.a, 1.b)
        // assumption: opened means all opened tickets, including those who were closed
        System.out.println("=== Statistics of all opened tickets ===\n");


        System.out.println("By Severities: " + ticketsMgr.getStatistics() + "\n");
        System.out.println("By CVEs: " + ticketsMgr.getCVEStatistics() + "\n");

        System.out.println("===========\n");

        // print how many open tickets with CVEs exist (Task 2.a)
        // assumption: null resolution means 'open'
        long countOpenCVE = ticketsMgr.getTickets().stream()
                .filter(ticket ->
                        (ticket.getResolution() == null
                                && ticket instanceof ITicketCVE))
                .count();
        System.out.println("Count of open tickets with CVE: " + countOpenCVE + "\n");

        // print how many closed tickets with Severity High exist (Task 2.b)
        long countClosedHighSeverity = ticketsMgr.getTickets().stream()
                .filter(ticket ->
                            (ticket.getResolution() != null
                                    && ticket instanceof ITicketSeverity
                                    && ((ITicketSeverity) ticket).getSeverity() == ITicketSeverity.Severity.HIGH))
                .count();

        System.out.println("Count of closed tickets with severity High: " + countClosedHighSeverity + "\n");
    }


    private static ITicket generateRandomTicket() {
        Random rand = new Random();

        // select a random ticket type
        TicketBase.TicketType[] ticketTypeValues = TicketBase.TicketType.values();
        TicketBase.TicketType type = ticketTypeValues[rand.nextInt(ticketTypeValues.length)];

        String description = "[Description placeholder]";

        // select a random ticket severity
        ITicketSeverity.Severity[] severityValues = ITicketSeverity.Severity.values();
        ITicketSeverity.Severity severity = severityValues[rand.nextInt(severityValues.length)];

        // select a random CVE
        String cve = Consts.CVES[rand.nextInt(Consts.CVES.length)];

        TicketBase newTicket;
        switch (type) {
            case SECURITY:
                newTicket = new TicketTypeSecurity(description, severity, cve);
                break;
            case CONFIGURATION:
                newTicket = new TicketTypeConfiguration(description, severity);
                break;
            case BEST_PRACTICE:
            default:
                newTicket = new TicketTypeBestPractice(description, severity, cve);
        }

        // decide randomly if to close the ticket
        if (rand.nextInt(4) == 1) {
            newTicket.setResolutionAndClose("[Resolution placeholder]");
        }

        return newTicket;
    }

}
