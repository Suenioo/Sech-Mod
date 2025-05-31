package net.sech.safiomod.entity.client;

import com.ibm.icu.text.Normalizer2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.sech.safiomod.entity.animations.ModAnimationDefinitions;
import net.sech.safiomod.entity.custom.BoykisserEntity;
import net.sech.safiomod.entity.custom.ChechuEntity;

public class BoykisserModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart body;
	private final ModelPart body_rotation;
	private final ModelPart sentarse;
	private final ModelPart sentarse2;
	private final ModelPart rotacion;
	private final ModelPart alturasentado;
	private final ModelPart todo;
	private final ModelPart tronco5;
	private final ModelPart troncovalanceo;
	private final ModelPart meciendose;
	private final ModelPart troncoverdadero;
	private final ModelPart body_sub_10;
	private final ModelPart bientre5;
	private final ModelPart cabeza;
	private final ModelPart cabeza2;
	private final ModelPart cabeza5;
	private final ModelPart cabezasentada;
	private final ModelPart fleco;
	private final ModelPart fleco2;
	private final ModelPart Orejas;
	private final ModelPart orejaisq;
	private final ModelPart orejader;
	private final ModelPart cachetes;
	private final ModelPart cacheteisq;
	private final ModelPart cacheteder;
	private final ModelPart osico;
	private final ModelPart ojosnormales;
	private final ModelPart normalesbajoataque;
	private final ModelPart ojoscerrados;
	private final ModelPart contraxsent;
	private final ModelPart sentadobajoataque;
	private final ModelPart ojoscerrados2;
	private final ModelPart ojoscerrados3;
	private final ModelPart bestio;
	private final ModelPart ojoscerrados5;
	private final ModelPart mamas4;
	private final ModelPart colasentada;
	private final ModelPart Cola;
	private final ModelPart Cola1;
	private final ModelPart Cola2;
	private final ModelPart Cola3;
	private final ModelPart Cola4;
	private final ModelPart brazos4;
	private final ModelPart brazos5;
	private final ModelPart braisq5;
	private final ModelPart sup7;
	private final ModelPart sup8;
	private final ModelPart supisq;
	private final ModelPart inf8;
	private final ModelPart brader5;
	private final ModelPart sup10;
	private final ModelPart sup9;
	private final ModelPart supder;
	private final ModelPart inf9;
	private final ModelPart piernasvalanceo;
	private final ModelPart piernas6;
	private final ModelPart Piernas5;
	private final ModelPart piernaisq5;
	private final ModelPart muslo8;
	private final ModelPart gluteo8;
	private final ModelPart pie8;
	private final ModelPart piesentado;
	private final ModelPart piernader5;
	private final ModelPart muslo9;
	private final ModelPart gluteo9;
	private final ModelPart pie9;

	public BoykisserModel(ModelPart root) {
		this.body = root.getChild("body");
		this.body_rotation = this.body.getChild("body_rotation");
		this.sentarse = this.body_rotation.getChild("sentarse");
		this.sentarse2 = this.sentarse.getChild("sentarse2");
		this.rotacion = this.sentarse2.getChild("rotacion");
		this.alturasentado = this.rotacion.getChild("alturasentado");
		this.todo = this.alturasentado.getChild("todo");
		this.tronco5 = this.todo.getChild("tronco5");
		this.troncovalanceo = this.tronco5.getChild("troncovalanceo");
		this.meciendose = this.troncovalanceo.getChild("meciendose");
		this.troncoverdadero = this.meciendose.getChild("troncoverdadero");
		this.body_sub_10 = this.troncoverdadero.getChild("body_sub_10");
		this.bientre5 = this.troncoverdadero.getChild("bientre5");
		this.cabeza = this.troncoverdadero.getChild("cabeza");
		this.cabeza2 = this.cabeza.getChild("cabeza2");
		this.cabeza5 = this.cabeza2.getChild("cabeza5");
		this.cabezasentada = this.cabeza5.getChild("cabezasentada");
		this.fleco = this.cabezasentada.getChild("fleco");
		this.fleco2 = this.cabezasentada.getChild("fleco2");
		this.Orejas = this.cabezasentada.getChild("Orejas");
		this.orejaisq = this.Orejas.getChild("orejaisq");
		this.orejader = this.Orejas.getChild("orejader");
		this.cachetes = this.cabezasentada.getChild("cachetes");
		this.cacheteisq = this.cachetes.getChild("cacheteisq");
		this.cacheteder = this.cachetes.getChild("cacheteder");
		this.osico = this.cabezasentada.getChild("osico");
		this.ojosnormales = this.cabezasentada.getChild("ojosnormales");
		this.normalesbajoataque = this.ojosnormales.getChild("normalesbajoataque");
		this.ojoscerrados = this.cabezasentada.getChild("ojoscerrados");
		this.contraxsent = this.ojoscerrados.getChild("contraxsent");
		this.sentadobajoataque = this.contraxsent.getChild("sentadobajoataque");
		this.ojoscerrados2 = this.cabezasentada.getChild("ojoscerrados2");
		this.ojoscerrados3 = this.ojoscerrados2.getChild("ojoscerrados3");
		this.bestio = this.cabezasentada.getChild("bestio");
		this.ojoscerrados5 = this.bestio.getChild("ojoscerrados5");
		this.mamas4 = this.troncoverdadero.getChild("mamas4");
		this.colasentada = this.troncoverdadero.getChild("colasentada");
		this.Cola = this.colasentada.getChild("Cola");
		this.Cola1 = this.Cola.getChild("Cola1");
		this.Cola2 = this.Cola1.getChild("Cola2");
		this.Cola3 = this.Cola2.getChild("Cola3");
		this.Cola4 = this.Cola3.getChild("Cola4");
		this.brazos4 = this.meciendose.getChild("brazos4");
		this.brazos5 = this.brazos4.getChild("brazos5");
		this.braisq5 = this.brazos5.getChild("braisq5");
		this.sup7 = this.braisq5.getChild("sup7");
		this.sup8 = this.sup7.getChild("sup8");
		this.supisq = this.sup8.getChild("supisq");
		this.inf8 = this.supisq.getChild("inf8");
		this.brader5 = this.brazos5.getChild("brader5");
		this.sup10 = this.brader5.getChild("sup10");
		this.sup9 = this.sup10.getChild("sup9");
		this.supder = this.sup9.getChild("supder");
		this.inf9 = this.supder.getChild("inf9");
		this.piernasvalanceo = this.tronco5.getChild("piernasvalanceo");
		this.piernas6 = this.piernasvalanceo.getChild("piernas6");
		this.Piernas5 = this.piernas6.getChild("Piernas5");
		this.piernaisq5 = this.Piernas5.getChild("piernaisq5");
		this.muslo8 = this.piernaisq5.getChild("muslo8");
		this.gluteo8 = this.muslo8.getChild("gluteo8");
		this.pie8 = this.muslo8.getChild("pie8");
		this.piesentado = this.pie8.getChild("piesentado");
		this.piernader5 = this.Piernas5.getChild("piernader5");
		this.muslo9 = this.piernader5.getChild("muslo9");
		this.gluteo9 = this.muslo9.getChild("gluteo9");
		this.pie9 = this.muslo9.getChild("pie9");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 17.5F, 0.5F));

		PartDefinition body_rotation = body.addOrReplaceChild("body_rotation", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition sentarse = body_rotation.addOrReplaceChild("sentarse", CubeListBuilder.create(), PartPose.offset(0.0F, -71.0F, -19.0F));

		PartDefinition sentarse2 = sentarse.addOrReplaceChild("sentarse2", CubeListBuilder.create(), PartPose.offset(0.0F, 136.0F, 9.0F));

		PartDefinition rotacion = sentarse2.addOrReplaceChild("rotacion", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -65.5F, 8.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition alturasentado = rotacion.addOrReplaceChild("alturasentado", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition todo = alturasentado.addOrReplaceChild("todo", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition tronco5 = todo.addOrReplaceChild("tronco5", CubeListBuilder.create(), PartPose.offset(0.0F, -4.5F, 0.0F));

		PartDefinition troncovalanceo = tronco5.addOrReplaceChild("troncovalanceo", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition meciendose = troncovalanceo.addOrReplaceChild("meciendose", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition troncoverdadero = meciendose.addOrReplaceChild("troncoverdadero", CubeListBuilder.create().texOffs(32, 48).addBox(-2.5F, -2.0F, -2.0F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 59).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition body_sub_10 = troncoverdadero.addOrReplaceChild("body_sub_10", CubeListBuilder.create().texOffs(10, 73).mirror().addBox(0.1F, -1.0F, -1.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(42, 56).mirror().addBox(0.1F, -1.0F, -4.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bientre5 = troncoverdadero.addOrReplaceChild("bientre5", CubeListBuilder.create().texOffs(25, 74).addBox(-3.0F, -0.1F, -3.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.09F)), PartPose.offset(0.0F, 5.0F, 1.0F));

		PartDefinition cabeza = troncoverdadero.addOrReplaceChild("cabeza", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition cabeza2 = cabeza.addOrReplaceChild("cabeza2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cabeza5 = cabeza2.addOrReplaceChild("cabeza5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition cabezasentada = cabeza5.addOrReplaceChild("cabezasentada", CubeListBuilder.create().texOffs(0, 31).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 31).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fleco = cabezasentada.addOrReplaceChild("fleco", CubeListBuilder.create().texOffs(34, 87).addBox(-2.0F, -5.0F, 1.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -6.0F, -4.5F));

		PartDefinition fleco2 = cabezasentada.addOrReplaceChild("fleco2", CubeListBuilder.create().texOffs(41, 99).addBox(-2.0F, -4.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -4.5F, 0.0F, -0.1745F, 0.0F));

		PartDefinition Orejas = cabezasentada.addOrReplaceChild("Orejas", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition orejaisq = Orejas.addOrReplaceChild("orejaisq", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -3.5F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 31).addBox(-3.0F, -5.5F, -0.5F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -1.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition orejader = Orejas.addOrReplaceChild("orejader", CubeListBuilder.create().texOffs(58, 33).mirror().addBox(0.0F, -3.5F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 23).mirror().addBox(-3.0F, -5.5F, -0.5F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, -1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cachetes = cabezasentada.addOrReplaceChild("cachetes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -7.5F));

		PartDefinition cacheteisq = cachetes.addOrReplaceChild("cacheteisq", CubeListBuilder.create().texOffs(36, 89).addBox(-1.0F, -3.0F, 3.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cacheteder = cachetes.addOrReplaceChild("cacheteder", CubeListBuilder.create().texOffs(36, 89).mirror().addBox(-1.0F, -3.0F, 3.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition osico = cabezasentada.addOrReplaceChild("osico", CubeListBuilder.create().texOffs(26, 81).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.65F))
		.texOffs(26, 81).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition ojosnormales = cabezasentada.addOrReplaceChild("ojosnormales", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -4.5F));

		PartDefinition normalesbajoataque = ojosnormales.addOrReplaceChild("normalesbajoataque", CubeListBuilder.create().texOffs(7, 22).addBox(-4.0F, -8.0F, 0.5F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ojoscerrados = cabezasentada.addOrReplaceChild("ojoscerrados", CubeListBuilder.create().texOffs(0, 85).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition contraxsent = ojoscerrados.addOrReplaceChild("contraxsent", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition sentadobajoataque = contraxsent.addOrReplaceChild("sentadobajoataque", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -8.0F, 0.5F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ojoscerrados2 = cabezasentada.addOrReplaceChild("ojoscerrados2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition ojoscerrados3 = ojoscerrados2.addOrReplaceChild("ojoscerrados3", CubeListBuilder.create().texOffs(16, 85).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bestio = cabezasentada.addOrReplaceChild("bestio", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition ojoscerrados5 = bestio.addOrReplaceChild("ojoscerrados5", CubeListBuilder.create().texOffs(0, 103).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition mamas4 = troncoverdadero.addOrReplaceChild("mamas4", CubeListBuilder.create().texOffs(25, 66).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.199F))
		.texOffs(44, 70).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition colasentada = troncoverdadero.addOrReplaceChild("colasentada", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 1.0F));

		PartDefinition Cola = colasentada.addOrReplaceChild("Cola", CubeListBuilder.create().texOffs(40, 64).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Cola1 = Cola.addOrReplaceChild("Cola1", CubeListBuilder.create().texOffs(48, 81).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Cola2 = Cola1.addOrReplaceChild("Cola2", CubeListBuilder.create().texOffs(48, 89).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.5F, 4.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Cola3 = Cola2.addOrReplaceChild("Cola3", CubeListBuilder.create().texOffs(40, 78).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 4.0F, 4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Cola4 = Cola3.addOrReplaceChild("Cola4", CubeListBuilder.create().texOffs(40, 69).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition brazos4 = meciendose.addOrReplaceChild("brazos4", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition brazos5 = brazos4.addOrReplaceChild("brazos5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition braisq5 = brazos5.addOrReplaceChild("braisq5", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition sup7 = braisq5.addOrReplaceChild("sup7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition sup8 = sup7.addOrReplaceChild("sup8", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition supisq = sup8.addOrReplaceChild("supisq", CubeListBuilder.create().texOffs(56, 47).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(58, 63).addBox(-2.5F, -2.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition inf8 = supisq.addOrReplaceChild("inf8", CubeListBuilder.create().texOffs(56, 54).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 70).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.19F)), PartPose.offset(-0.5F, 3.0F, 0.0F));

		PartDefinition brader5 = brazos5.addOrReplaceChild("brader5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition sup10 = brader5.addOrReplaceChild("sup10", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition sup9 = sup10.addOrReplaceChild("sup9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition supder = sup9.addOrReplaceChild("supder", CubeListBuilder.create().texOffs(56, 47).mirror().addBox(-0.5F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false)
		.texOffs(58, 63).mirror().addBox(0.5F, -2.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition inf9 = supder.addOrReplaceChild("inf9", CubeListBuilder.create().texOffs(56, 54).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(56, 70).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.19F)).mirror(false), PartPose.offset(0.5F, 3.0F, 0.0F));

		PartDefinition piernasvalanceo = tronco5.addOrReplaceChild("piernasvalanceo", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition piernas6 = piernasvalanceo.addOrReplaceChild("piernas6", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, -0.5F));

		PartDefinition Piernas5 = piernas6.addOrReplaceChild("Piernas5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition piernaisq5 = Piernas5.addOrReplaceChild("piernaisq5", CubeListBuilder.create(), PartPose.offset(-1.0F, 2.0F, 0.0F));

		PartDefinition muslo8 = piernaisq5.addOrReplaceChild("muslo8", CubeListBuilder.create().texOffs(0, 47).addBox(-2.9F, -2.0F, -2.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition gluteo8 = muslo8.addOrReplaceChild("gluteo8", CubeListBuilder.create().texOffs(0, 70).addBox(-4.1F, 3.0F, 3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(10, 77).addBox(-6.1F, 3.0F, 4.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -4.0F, -4.0F));

		PartDefinition pie8 = muslo8.addOrReplaceChild("pie8", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition piesentado = pie8.addOrReplaceChild("piesentado", CubeListBuilder.create().texOffs(0, 77).addBox(-2.0F, 5.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-2.001F, -1.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition piernader5 = Piernas5.addOrReplaceChild("piernader5", CubeListBuilder.create(), PartPose.offset(1.0F, 2.0F, 0.0F));

		PartDefinition muslo9 = piernader5.addOrReplaceChild("muslo9", CubeListBuilder.create().texOffs(16, 47).mirror().addBox(-0.1F, -8.0F, 1.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(-1.0F, 6.0F, -3.5F));

		PartDefinition gluteo9 = muslo9.addOrReplaceChild("gluteo9", CubeListBuilder.create().texOffs(14, 70).mirror().addBox(0.1F, 3.0F, 3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(10, 77).mirror().addBox(2.1F, 3.0F, 4.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition pie9 = muslo9.addOrReplaceChild("pie9", CubeListBuilder.create().texOffs(12, 59).addBox(-0.999F, -1.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(14, 77).addBox(-1.0F, 5.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 64, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.WALK_BK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((BoykisserEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE_BK, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.cabeza.yRot = (pNetHeadYaw * ((float)Math.PI / 180F));
		this.cabeza.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return body;
	}
}