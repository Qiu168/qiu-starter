package com.cat.valid;

//import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * todo:求大佬带带不会写啊，为什么就是不成功呢？
 * @author 14629
 */
//@AutoService(Processor.class)
@SupportedAnnotationTypes("com.cat.valid.MustBeEnum")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MustBeEnumProcessor extends AbstractProcessor {

    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(MustBeEnum.class)) {
            if (element.getKind() == ElementKind.INTERFACE) {
                checkImplementations((TypeElement) element);
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@MustBeEnum must be applied to an interface.");
            }
        }
        return true;
    }

    private void checkImplementations(TypeElement interfaceElement) {
        for (Element element : elementUtils.getAllMembers(interfaceElement)) {
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement classElement = (TypeElement) element;
                // 检查类是否是枚举类型
                if (classElement.getKind() != ElementKind.ENUM) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                            "Classes implementing @MustBeEnum annotated interface must be enums.",
                            classElement);
                }
            }
        }
    }
}