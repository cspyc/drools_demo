package lesson1;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import droolscours.Account;
import util.KnowledgeSessionHelper;
import util.OutputDisplay;

public class TestLesson1 {

	//create fixture
	
	StatelessKieSession sessionStateless = null;
	KieSession sessionStateful = null;
	static KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper
				.createRuleBase();
	}
	
	@Before
	public void setUp() {
		System.out.println("-----------Test Before------------");
		System.out.println("Did you see something?");
	}
	
	@After 
	public void tearDown() {
		System.out.println("So you saw something ;)");
		System.out.println("------------Test After-----------");
		
	}
	
	
	@Test
	public void testFirstOne() {
		sessionStateful = KnowledgeSessionHelper
				.getStatefulKnowledgeSession(kieContainer, "ksessionR");
		
		//set global variable
		OutputDisplay  outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResults", outputDisplay);
		
		Account a = new Account();
		FactHandle handle = sessionStateful.insert(a);
		
		System.out.println("First fire all rules");
		sessionStateful.fireAllRules();
		
		sessionStateful.update(handle, a);
		System.out.println("Second fire all rules");
		sessionStateful.fireAllRules();
	}
	
	@Test
	public void testRuleOneFactWithFactAndUsageOfGlobalAndCallBack() {
		sessionStateful = KnowledgeSessionHelper
				.getStatefulKnowledgeSession(kieContainer, "ksessionR");
		
		sessionStateful.addEventListener(new RuleRuntimeEventListener() {				

				@Override
				public void objectDeleted(ObjectDeletedEvent event) {
					System.out.println("Object was retracted \n"
							+ event.getOldObject().toString());
					
				}
	
				@Override
				public void objectInserted(ObjectInsertedEvent event) {
					System.out.println("Object was inserted \n"
							+ event.getObject().toString());
					
				}
	
				@Override
				public void objectUpdated(ObjectUpdatedEvent event) {
					System.out.println("Object was updated \n"
							+ event.getObject().toString());
					
				}
			});
		
			Account a = new Account();
			a.setAccountNo(10);
			
			FactHandle handlea = sessionStateful.insert(a);
			a.setBalance(12.25);
			
			sessionStateful.update(handlea, a);
			sessionStateful.delete(handlea);
			sessionStateful.fireAllRules();		
	}
	
	


}
