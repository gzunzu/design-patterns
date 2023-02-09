package app;

import clinic.Clinic;
import dto.babysitting.VisitableDTO;
import dto.nutritionist.PatientFactoryDTO;
import lombok.extern.slf4j.Slf4j;
import utils.JsonHelper;
import utils.PatientFactory;
import visitor.Babysitter;

import java.util.List;

@Slf4j
public class OopLearningApplication {

    private static final String BASE_RESOURCES_PATH = "application/src/main/resources/";

    private static void executeBabysittingExample() {
        log.info("\n\n---An example execution of the Babysitter module---\n ");

        VisitableDTO visitableDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "babysitting/visitables.json", VisitableDTO.class);

        final Babysitter babysitter = new Babysitter();
        babysitter.admit(visitableDTO.getBabies());
        babysitter.admit(visitableDTO.getToddlers());
        babysitter.admit(visitableDTO.getPreschoolers());
        babysitter.admit(visitableDTO.getDogs());
        babysitter.shuffle();
        log.info(babysitter.takeCare());
        babysitter.finishWork();
    }

    private static void executeNutritionistExample() {
        log.info("\n\n---An example execution of the Nutritionist module---\n ");

        List<PatientFactoryDTO> patientFactoryDTOList =
                JsonHelper.readJsonArrayFile(BASE_RESOURCES_PATH + "nutritionist/patients.json", PatientFactoryDTO.class);

        final Clinic clinic = new Clinic();
        patientFactoryDTOList.stream().forEach(dto -> clinic.admit(PatientFactory.getPatient(dto.getName(), dto.getIsoCode())));
        clinic.shuffle();
        log.info(clinic.seePatients());
        clinic.finishWork();
    }

    public static void main(String[] args) {
        executeBabysittingExample();
        executeNutritionistExample();
    }
}
