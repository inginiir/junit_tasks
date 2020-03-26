package testing;


import org.junit.*;

public class CRUDTest {
    private CRUD crud;
    private Entity entity;
    @Before
    public void init() {
        crud = new CRUD();
        entity = new Entity();
        entity.setId(1);
        crud.create(entity);
    }
    @After
    public void after() {
        crud.delete(entity.getId());
    }
    @Test
    public void testCreate() {
        Entity entity1 = new Entity();
        entity1.setId(3);
        Assert.assertTrue(crud.create(entity1));
        Assert.assertFalse(crud.create(entity1));
    }
    @Ignore("Test ignore")
    @Test(expected = Exception.class)
    public void testRead() {
        Assert.assertNotNull(crud.read(1));
        Assert.assertNull(crud.read(2));
    }
    @Test(timeout = 1000)
    public void testUpdate() {
        Assert.assertTrue(crud.update(entity));
        entity.setId(2);
        Assert.assertFalse(crud.update(entity));
    }
    @Test
    public void testDelete() {
        Assert.assertTrue(crud.delete(1));
        Assert.assertFalse(crud.delete(2));
    }

}
