package app;

import dto.BabysitterDTO;
import lombok.extern.slf4j.Slf4j;
import utils.JsonHelper;
import visitor.Babysitter;

@Slf4j
public class OopLearningApplication {

    private static void executeBabysittingExample() {
        BabysitterDTO babysitterDTO = (BabysitterDTO)
                JsonHelper.readJsonFile("application/src/main/resources/babysitting/exampledata.json", BabysitterDTO.class);

        log.info("\n---An example execution of the Babysitter module---\n ");

        final Babysitter BABYSITTER = new Babysitter();
        BABYSITTER.admit(babysitterDTO.getBabies());
        BABYSITTER.admit(babysitterDTO.getToddlers());
        BABYSITTER.admit(babysitterDTO.getPreschoolers());
        BABYSITTER.admit(babysitterDTO.getDogs());
        log.info(BABYSITTER.takeCare());
        BABYSITTER.finishWork();
    }

    public static void main(String[] args) {
        executeBabysittingExample();
    }
}
