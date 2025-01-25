package parkinglot.dtos;

import parkinglot.models.Ticket;

public class IssueTicketResponseDto {
    private ResponseStatus responseStatus;
    private String errorMessage;
    private Ticket ticket; // we shouldn't do it, I am just doing it to save time.

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
