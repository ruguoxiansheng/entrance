package mydefineComponent;

import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;



public  final class  Scanner extends ClassPathBeanDefinitionScanner {

	public Scanner(BeanDefinitionRegistry registry) {
		super(registry);
		// TODO Auto-generated constructor stub
	}

	public void registerDefaultFilters() {
		this.addIncludeFilter(new AnnotationTypeFilter(MyDefineComponent.class));
	}

	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
		for (BeanDefinitionHolder holder : beanDefinitions) {
			GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
			definition.getPropertyValues().add("innerClassName", definition.getBeanClassName());
			definition.setBeanClass(FactoryBeanTest.class);
		}
		return beanDefinitions;
	}

	public boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return super.isCandidateComponent(beanDefinition) && beanDefinition.getMetadata()
				.hasAnnotation(MyDefineComponent.class.getName());
	}

}
