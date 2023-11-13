package com.cat.valid;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @see MustBeEnum
 * @author _qiu
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.cat.valid.MustBeEnum")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MustBeEnumProcessor extends AbstractProcessor {

    private Elements elementUtils;
    private final List<Element> interfaceList=new ArrayList<>();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        interfaceList.add(processingEnv.getElementUtils().getTypeElement("com.cat.json.sensitive.Desensitize"));
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(MustBeEnum.class)) {
            if (element.getKind() == ElementKind.INTERFACE) {
                interfaceList.add(element);
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@MustBeEnum must be applied to an interface.",element);
            }
        }
        checkImplementations(roundEnv);
        return true;
    }

    private void checkImplementations(RoundEnvironment roundEnv) {

        if(interfaceList.size()==0){
            return;
        }

        for (Element element : roundEnv.getRootElements()) {
            if (element.getKind() == ElementKind.CLASS) {
                for (Element inter :interfaceList){
                    if(processingEnv.getTypeUtils().isSubtype(element.asType(),inter.asType())){
                        TypeElement classElement = (TypeElement) element;
                        if (classElement.getKind() != ElementKind.ENUM) {
                            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                    "Classes implementing @MustBeEnum annotated interface must be enums.",
                                    classElement);
                        }
                        break;
                    }
                }

            }
        }
    }
}