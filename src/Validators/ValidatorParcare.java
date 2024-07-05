package Validators;

import Domain.Parcare;


public class ValidatorParcare {

    public void validate(Parcare parcare) throws ValidationException {
        if (parcare.getAdresa() == null || parcare.getAdresa().isEmpty()) {
            throw new ValidationException("Adresa nu poate fi goală!");
        }

        if (parcare.getNume() == null || parcare.getNume().isEmpty()) {
            throw new ValidationException("Numele nu poate fi gol!");
        }

        if (parcare.getDimensiune() <= 0) {
            throw new ValidationException("Dimensiunea trebuie să fie mai mare decât 0!");
        }

        if (parcare.getLocuriTotale() < 0) {
            throw new ValidationException("Numărul de locuri totale nu poate fi negativ!");
        }

    }
}

