package net.codjo.mad.server;
import net.codjo.mad.common.TestUtil;
import net.codjo.test.common.depend.Dependency;
import net.codjo.test.common.depend.PackageDependencyTestCase;

public class DependencyTest extends PackageDependencyTestCase {

    public void test_dependency() throws Exception {
        Dependency dependency = createDependency();
        dependency.assertDependency(TestUtil.getFileForJavaVersion("dependency.txt"));
    }


    public void test_dependencyTest() throws Exception {
        Dependency dependency = createTestDependency();
        dependency.assertDependency(TestUtil.getFileForJavaVersion("dependencyTest.txt"));
    }
}
