package utcn.labs.sd.bankingservice.domain.data.converter;

import utcn.labs.sd.bankingservice.domain.data.entity.Client;
import utcn.labs.sd.bankingservice.domain.dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class ClientConverter {

    private ClientConverter() {
    }

    public static ClientDTO toDto(Client entity) {
        ClientDTO dto = null;
        if (entity != null) {
            dto = new ClientDTO(entity.getSsn(), entity.getFirstname(), entity.getLastname(), entity.getIdentityCardNumber(), entity.getAddress(),
                    entity.getEmail(), AccountConverter.toDto(entity.getAccountList()));
        }
        return dto;
    }

    public static List<ClientDTO> toDto(List<Client> entityList) {
        List<ClientDTO> clientDtos = new ArrayList<>();
        if ((entityList != null) && (!entityList.isEmpty())) {
            for (Client model : entityList) {
                clientDtos.add(toDto(model));
            }
        }
        return clientDtos;
    }
}
