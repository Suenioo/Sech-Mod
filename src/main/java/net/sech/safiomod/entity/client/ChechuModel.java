package net.sech.safiomod.entity.client;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


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
import net.sech.safiomod.entity.custom.ChechuEntity;

public class ChechuModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Chechu;
	private final ModelPart body;
	private final ModelPart ArmL;
	private final ModelPart ArmR;
	private final ModelPart LegR;
	private final ModelPart LegL;
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart Body2;
	private final ModelPart cube_r4;

	public ChechuModel(ModelPart root) {
		this.Chechu = root.getChild("Chechu");
		this.body = this.Chechu.getChild("body");
		this.ArmL = this.body.getChild("ArmL");
		this.ArmR = this.body.getChild("ArmR");
		this.LegR = this.body.getChild("LegR");
		this.LegL = this.body.getChild("LegL");
		this.Torso = this.body.getChild("Torso");
		this.Head = this.Torso.getChild("Head");
		this.cube_r1 = this.Head.getChild("cube_r1");
		this.cube_r2 = this.Head.getChild("cube_r2");
		this.cube_r3 = this.Head.getChild("cube_r3");
		this.Body2 = this.Torso.getChild("Body2");
		this.cube_r4 = this.Body2.getChild("cube_r4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Chechu = partdefinition.addOrReplaceChild("Chechu", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = Chechu.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ArmL = body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(48, 17).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 58).addBox(-1.0F, 2.0F, 0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -14.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition ArmR = body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(28, 58).addBox(-1.0F, 2.0F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(50, 46).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -14.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition LegR = body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(48, 34).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 7).addBox(-1.5F, 1.0F, -1.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -3.0F, 0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition LegL = body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(52, 34).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 12).addBox(-1.5F, 1.0F, -1.5F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.0F, 0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Torso = body.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(50, 52).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 23).addBox(-2.0F, -6.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 58).addBox(2.5F, -2.25F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 34).addBox(2.5F, -4.25F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 34).addBox(2.5F, -4.25F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(-3.0F, -7.0F, -4.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(22, 46).addBox(-3.0F, -6.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 46).addBox(-3.0F, -6.0F, 3.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 54).addBox(2.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.5F, 3.75F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(56, 57).addBox(0.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.0F, -0.75F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Body2 = Torso.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(36, 53).addBox(-1.5F, 0.0F, 2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-3.5F, -2.0F, -6.0F, 8.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -11.0F, -7.0F, 10.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-2.5F, -14.0F, -3.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 37).addBox(-3.5F, -12.0F, -4.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r4 = Body2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 58).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -11.25F, 0.0F, 0.0F, 0.0F, 0.3491F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((ChechuEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.Head.yRot = (pNetHeadYaw * ((float)Math.PI / 180F)) + ((float)Math.PI / 2F);
		this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Chechu.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Chechu;
	}
}