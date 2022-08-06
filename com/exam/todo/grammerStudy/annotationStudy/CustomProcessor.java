package exam.todo.grammerStudy.annotationStudy;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public class CustomProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(CustomAnnotation.class);
        for (Element element : elementsAnnotatedWith) {
            System.out.println("element.getKind() = " + element.getKind());
            System.out.println("element.getSimpleName() = " + element.getSimpleName());
        }
        return true;
    }
}
