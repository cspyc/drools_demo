package lesson4a;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import droolscours.Account;
import droolscours.AccountingPeriod;
import util.KnowledgeSessionHelper;
import util.OutputDisplay;

public class TestLesson4a {
	static KieContainer kieContainer;
	KieSession sessionStatefull = null;

	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("------------Before------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("------------After ------------");
	}
	
	@Test
	public void testRuleFlow3() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-lesson4a");
		
		OutputDisplay display = new OutputDisplay();
		sessionStatefull.setGlobal("showResult", display);
		
		Account a = new Account();
		a.setBalance(500);		
		sessionStatefull.insert(a);
		
		AccountingPeriod period = new AccountingPeriod();
		sessionStatefull.insert(period);		

		sessionStatefull.fireAllRules();

	}
}
