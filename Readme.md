### Description
* The pattern-relationship is derived from a High Resolution (HR) image and its Low Resolution (LR) image and applying this relation on the interpolated Low Resolution image for converting it into a High Resolution image.

* We will use Active Sampling and Gaussian Process Regression algorithm to obtain a feature set and recognize pattern relationship respectively.

### Software Required

* **NET BEANS** 6.9.1 or higher.
* **JDK 1.6** or higher.
* **WEKA** Toolbar.

### Work Flow
**`Training Image Pairs:`**
The Image pair used in the training phase consists of High Resolution image and
Low Resolution image. The LR image is the interpolated version of the same HR
image i.e. the images belong to the same scene.

**`Feature Set:`**
Feature extraction in done using GLCM(Grey Level Co-occurrence Matrix) algorithm. Various features such as energy, contrast, co-relation, homogeneity of the pixels are calculated and values for the same are derived forming the base of the
feature extraction module.

**`GPR Modeling:`**
The pattern relation is derived using the GPR modeling. This relationship is formed from the feature subset derived using feature extraction algorithm and further applied on the feature set of the input interpolated low resolution image

#### Flow Diagram
![Flowchart](superresolution/FlowChart.png)

