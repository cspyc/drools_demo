import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import util.KnowledgeSessionHelper;

public class FirstTryTest {

	
	//创建fixture
	
	StatelessKieSession sessionStateless = null;
	KieSession sessionStateful = null;
	static KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	@Test
	public void testFirstOne() {
		sessionStateful = KnowledgeSessionHelper
				.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
	}

}
