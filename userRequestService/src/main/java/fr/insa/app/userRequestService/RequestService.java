package fr.insa.app.userRequestService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private List<Request> requests = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Request> getAllRequests() {
        return requests;
    }

    public Request getRequestById(Long id) {
        return requests.stream().filter(request -> request.getId().equals(id)).findFirst().orElse(null);
    }

    public Request createRequest(RequestDto requestDto) {
        Request request = new Request(idCounter++, requestDto.getDescription(), RequestStatus.WAITING);
        requests.add(request);
        return request;
    }

    public Request updateRequestStatus(Long id, RequestStatus status) {
        Request request = getRequestById(id);
        if (request != null) {
            request.setStatus(status);
        }
        return request;
    }
}
