package org.seasar.doma.boot.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.seasar.doma.boot.event.annotation.*;
import org.seasar.doma.jdbc.entity.*;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("unchecked")
public class DomaEventEntityListenerTest {
	@Test
	public void handlePreInsert() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PreInsertHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PreInsertContext ctx = mock(PreInsertContext.class);
		Entity entity = new Entity();
		entityListener.preInsert(entity, ctx);
		PreInsertHandler handler = context.getBean(PreInsertHandler.class);
		assertThat(handler.entity).isSameAs(entity);
	}

	@Test
	public void handlePreInsertWithContext() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PreInsertHandlerWithContext.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PreInsertContext ctx = mock(PreInsertContext.class);
		Entity entity = new Entity();
		entityListener.preInsert(entity, ctx);
		PreInsertHandlerWithContext handler = context
				.getBean(PreInsertHandlerWithContext.class);
		assertThat(handler.entity).isSameAs(entity);
		assertThat(handler.ctx).isSameAs(ctx);
	}

	@Test
	public void handlePreUpdate() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PreUpdateHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PreUpdateContext ctx = mock(PreUpdateContext.class);
		Entity entity = new Entity();
		entityListener.preUpdate(entity, ctx);
		PreUpdateHandler handler = context.getBean(PreUpdateHandler.class);
		assertThat(handler.entity).isSameAs(entity);
	}

	@Test
	public void handlePreUpdateWithContext() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PreUpdateHandlerWithContext.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PreUpdateContext ctx = mock(PreUpdateContext.class);
		Entity entity = new Entity();
		entityListener.preUpdate(entity, ctx);
		PreUpdateHandlerWithContext handler = context
				.getBean(PreUpdateHandlerWithContext.class);
		assertThat(handler.entity).isSameAs(entity);
		assertThat(handler.ctx).isSameAs(ctx);
	}

	@Test
	public void handlePreDelete() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PreDeleteHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PreDeleteContext ctx = mock(PreDeleteContext.class);
		Entity entity = new Entity();
		entityListener.preDelete(entity, ctx);
		PreDeleteHandler handler = context.getBean(PreDeleteHandler.class);
		assertThat(handler.entity).isSameAs(entity);
	}

	@Test
	public void handlePreDeleteWithContext() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PreDeleteHandlerWithContext.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PreDeleteContext ctx = mock(PreDeleteContext.class);
		Entity entity = new Entity();
		entityListener.preDelete(entity, ctx);
		PreDeleteHandlerWithContext handler = context
				.getBean(PreDeleteHandlerWithContext.class);
		assertThat(handler.entity).isSameAs(entity);
		assertThat(handler.ctx).isSameAs(ctx);
	}

	@Test
	public void handlePostInsert() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PostInsertHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PostInsertContext ctx = mock(PostInsertContext.class);
		Entity entity = new Entity();
		entityListener.postInsert(entity, ctx);
		PostInsertHandler handler = context.getBean(PostInsertHandler.class);
		assertThat(handler.entity).isSameAs(entity);
	}

	@Test
	public void handlePostInsertWithContext() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PostInsertHandlerWithContext.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PostInsertContext ctx = mock(PostInsertContext.class);
		Entity entity = new Entity();
		entityListener.postInsert(entity, ctx);
		PostInsertHandlerWithContext handler = context
				.getBean(PostInsertHandlerWithContext.class);
		assertThat(handler.entity).isSameAs(entity);
		assertThat(handler.ctx).isSameAs(ctx);
	}

	@Test
	public void handlePostUpdate() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PostUpdateHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PostUpdateContext ctx = mock(PostUpdateContext.class);
		Entity entity = new Entity();
		entityListener.postUpdate(entity, ctx);
		PostUpdateHandler handler = context.getBean(PostUpdateHandler.class);
		assertThat(handler.entity).isSameAs(entity);
	}

	@Test
	public void handlePostUpdateWithContext() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PostUpdateHandlerWithContext.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PostUpdateContext ctx = mock(PostUpdateContext.class);
		Entity entity = new Entity();
		entityListener.postUpdate(entity, ctx);
		PostUpdateHandlerWithContext handler = context
				.getBean(PostUpdateHandlerWithContext.class);
		assertThat(handler.entity).isSameAs(entity);
		assertThat(handler.ctx).isSameAs(ctx);
	}

	@Test
	public void handlePostDelete() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PostDeleteHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PostDeleteContext ctx = mock(PostDeleteContext.class);
		Entity entity = new Entity();
		entityListener.postDelete(entity, ctx);
		PostDeleteHandler handler = context.getBean(PostDeleteHandler.class);
		assertThat(handler.entity).isSameAs(entity);
	}

	@Test
	public void handlePostDeleteWithContext() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PostDeleteHandlerWithContext.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PostDeleteContext ctx = mock(PostDeleteContext.class);
		Entity entity = new Entity();
		entityListener.postDelete(entity, ctx);
		PostDeleteHandlerWithContext handler = context
				.getBean(PostDeleteHandlerWithContext.class);
		assertThat(handler.entity).isSameAs(entity);
		assertThat(handler.ctx).isSameAs(ctx);
	}

	@Test
	public void anotherEntity() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PreInsertHandler.class);
		context.register(PreInsertHandler2.class);
		context.refresh();

		DomaEventEntityListener<Entity2> entityListener = context
				.getBean(DomaEventEntityListener.class);

		PreInsertContext ctx = mock(PreInsertContext.class);
		Entity2 entity = new Entity2();
		entityListener.preInsert(entity, ctx);

		PreInsertHandler handler = context.getBean(PreInsertHandler.class);
		assertThat(handler.entity).isNull();

		PreInsertHandler2 handler2 = context.getBean(PreInsertHandler2.class);
		assertThat(handler2.entity).isSameAs(entity);
	}

	@Test
	public void multiHandlers() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(PrePostInsertHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);
		PrePostInsertHandler handler = context.getBean(PrePostInsertHandler.class);

		PreInsertContext preCtx = mock(PreInsertContext.class);
		PostInsertContext postCtx = mock(PostInsertContext.class);

		Entity entity = new Entity();
		entityListener.preInsert(entity, preCtx);
		assertThat(handler.preEntity).isSameAs(entity);
		entityListener.postInsert(entity, postCtx);
		assertThat(handler.postEntity).isSameAs(entity);
	}

	@Test
	public void multiAnnotations() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(InsertHandler.class);
		context.refresh();

		DomaEventEntityListener<Entity> entityListener = context
				.getBean(DomaEventEntityListener.class);
		InsertHandler handler = context.getBean(InsertHandler.class);

		PreInsertContext preCtx = mock(PreInsertContext.class);
		PostInsertContext postCtx = mock(PostInsertContext.class);

		Entity entity = new Entity();
		entityListener.preInsert(entity, preCtx);
		assertThat(handler.entity).isSameAs(entity);
		Entity entity2 = new Entity();
		entityListener.postInsert(entity2, postCtx);
		assertThat(handler.entity).isSameAs(entity2);
	}

	@Test(expected = BeanCreationException.class)
	public void noArg() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DomaEventEntityListener.class);
		context.register(AnnotatedDomaEventHandlerInvoker.class);
		context.register(NoArgHandler.class);
		context.refresh();
	}

	@org.seasar.doma.Entity
	public static class Entity {

	}

	@org.seasar.doma.Entity
	public static class Entity2 {

	}

	@DomaEventHandler
	static class PreInsertHandler {
		Entity entity;

		@HandlePreInsert
		public void handlePreInsert(Entity entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class PreInsertHandler2 {
		Entity2 entity;

		@HandlePreInsert
		public void handlePreInsert(Entity2 entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class PreInsertHandlerWithContext {
		Entity entity;
		PreInsertContext ctx;

		@HandlePreInsert
		public void handlePreInsert(Entity entity, PreInsertContext ctx) {
			this.entity = entity;
			this.ctx = ctx;
		}
	}

	@DomaEventHandler
	static class PreUpdateHandler {
		Entity entity;

		@HandlePreUpdate
		public void handlePreUpdate(Entity entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class PreUpdateHandlerWithContext {
		Entity entity;
		PreUpdateContext ctx;

		@HandlePreUpdate
		public void handlePreUpdate(Entity entity, PreUpdateContext ctx) {
			this.entity = entity;
			this.ctx = ctx;
		}
	}

	@DomaEventHandler
	static class PreDeleteHandler {
		Entity entity;

		@HandlePreDelete
		public void handlePreDelete(Entity entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class PreDeleteHandlerWithContext {
		Entity entity;
		PreDeleteContext ctx;

		@HandlePreDelete
		public void handlePreDelete(Entity entity, PreDeleteContext ctx) {
			this.entity = entity;
			this.ctx = ctx;
		}
	}

	@DomaEventHandler
	static class PostInsertHandler {
		Entity entity;

		@HandlePostInsert
		public void handlePostInsert(Entity entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class PostInsertHandlerWithContext {
		Entity entity;
		PostInsertContext ctx;

		@HandlePostInsert
		public void handlePostInsert(Entity entity, PostInsertContext ctx) {
			this.entity = entity;
			this.ctx = ctx;
		}
	}

	@DomaEventHandler
	static class PostUpdateHandler {
		Entity entity;

		@HandlePostUpdate
		public void handlePostUpdate(Entity entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class PostUpdateHandlerWithContext {
		Entity entity;
		PostUpdateContext ctx;

		@HandlePostUpdate
		public void handlePostUpdate(Entity entity, PostUpdateContext ctx) {
			this.entity = entity;
			this.ctx = ctx;
		}
	}

	@DomaEventHandler
	static class PostDeleteHandler {
		Entity entity;

		@HandlePostDelete
		public void handlePostDelete(Entity entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class PostDeleteHandlerWithContext {
		Entity entity;
		PostDeleteContext ctx;

		@HandlePostDelete
		public void handlePostDelete(Entity entity, PostDeleteContext ctx) {
			this.entity = entity;
			this.ctx = ctx;
		}
	}

	@DomaEventHandler
	static class PrePostInsertHandler {
		Entity preEntity;
		Entity postEntity;

		@HandlePreInsert
		public void handlePreInsert(Entity entity) {
			this.preEntity = entity;
		}

		@HandlePostInsert
		public void handlePostInsert(Entity entity) {
			this.postEntity = entity;
		}
	}

	@DomaEventHandler
	static class InsertHandler {
		Entity entity;

		@HandlePreInsert
		@HandlePostInsert
		public void handleInsert(Entity entity) {
			this.entity = entity;
		}
	}

	@DomaEventHandler
	static class NoArgHandler {
		@HandlePreInsert
		public void noarg() {
		}
	}
}
